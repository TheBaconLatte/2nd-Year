// Create the canvas

//variable declaration
var bgReady;
var bgImage;
var trumpReady;
var trumpImage;
var sandersReady;
var sandersImage;
var eagleReadyR; //right
var eagleImageR;
var eagleReadyL; //left
var eagleImageL;
var trump = {};
var sanders = {};
var eagle = {speed: 300};
var trumpsTrumped = 0;
var livesCounter = 3;
var keyPress = {};
var flipped;

function playTrump() {
	var sounds = ["trump_sounds/really_rich.wav",
	"trump_sounds/laughing.wav",
	"trump_sounds/mexico.wav",
	"trump_sounds/really_smart.wav",
	"trump_sounds/rapists.wav",
	"trump_sounds/bringing_drugs.wav",
	"trump_sounds/i_win.wav",
	"trump_sounds/better_than_me.wav",
	"trump_sounds/believe_me.wav",
	"trump_sounds/bigger_better.wav",
	"trump_sounds/disgusting.wav",
	"trump_sounds/great_again.wav",
	"trump_sounds/like_china.wav",
	"trump_sounds/love_saudis.wav"];

	var index = Math.floor(Math.random() * (sounds.length));
	document.getElementById("effects").innerHTML="<embed src=\""+sounds[index]+"\" hidden=\"true\" autostart=\"true\" loop=\"false\" />";
}

function playBernie() {
    var sounds = ["bernie_sounds/cut_military.wav",
	"bernie_sounds/healthcare.wav",
	"bernie_sounds/lets_do_it.wav",
	"bernie_sounds/raise_wages.wav",
	"bernie_sounds/simple_truth.wav"];
    var index = Math.floor(Math.random() * (sounds.length));
    document.getElementById("effects").innerHTML="<embed src=\""+sounds[index]+"\" hidden=\"true\" autostart=\"true\" loop=\"false\" />";
}

function loadObjects() { //make sure images are loaded in
	//Trump
	trumpReady = false;
	trumpImage = new Image();
	trumpImage.onload = function () {
		trumpReady = true;
	},
	trumpImage.src = "images/trumpetsmall.png";
	//Sanders
	sandersReady = false;
	sandersImage = new Image();
	sandersImage.onload = function () {
		sandersReady = true;
	},
	sandersImage.src = "images/BernieSanderssmall.png";
	//eagleR
	eagleReadyR = false;
	eagleImageR = new Image();
	eagleImageR.onload = function () {
		eagleReadyR = true;
	};
	eagleImageR.src = "images/eagle.png";
	//eagleL
	eagleReadyL = false;
	eagleImageL = new Image();
	eagleImageL.onload = function () {
		eagleReadyL = true;
	};
	eagleImageL.src = "images/eagleleft.png";
	//background
	bgReady = false;
	bgImage = new Image();
	bgImage.onload = function () {
		bgReady = true;
	};
	bgImage.src = "images/bg.png";
};

loadObjects();

addEventListener("keyup", function (e) {
	delete keyPress[e.keyCode];
}, false);

addEventListener("keydown", function (e) {
	keyPress[e.keyCode] = true;
}, false);

//keyboard input for arrow keys
var update = function (modifier) {
	if (38 in keyPress) {eagle.y -= eagle.speed * modifier;}	// up
	if (40 in keyPress) {eagle.y += eagle.speed * modifier;}	// down
	if (37 in keyPress) {
		eagle.x -= eagle.speed * modifier;
		flipped = true;
	}	// left
	if (39 in keyPress) {
		eagle.x += eagle.speed * modifier;
		flipped = false;
	}	// right

	//if eagle hits balloon, increment score
	if (eagle.x <= (trump.x + 32) && trump.x <= (eagle.x + 32) && eagle.y <= (trump.y + 32) && trump.y <= (eagle.y + 32)) {
		++trumpsTrumped;
		playTrump();
		reset();
	}

	//if eagle hits NEGABALLOON, lose a life
	if (eagle.x <= (sanders.x + 32) && sanders.x <= (eagle.x + 32) && eagle.y <= (sanders.y + 32) && sanders.y <= (eagle.y + 32)) {
		--livesCounter;
		playBernie();
		reset();
	}
 
	//if eagle tries to leave screen, reset position to screen centre
	if((eagle.x <= -60) || (eagle.x >= 550) || (eagle.y <= -50) || (eagle.y >= 520)) {
		eagle.x = canvas.width / 2;
		eagle.y = canvas.height / 2;
	}
};

var reset = function () {
	//setting starting positions for images (eagle centre, random balloons)
	eagle.x = canvas.width / 2;
	eagle.y = canvas.height / 2;
	trump.x = 32 + (Math.random() * (canvas.width - 64));
	trump.y = 32 + (Math.random() * (canvas.height - 64));
	sanders.x = 32 + (Math.random() * (canvas.width - 64));
	sanders.y = 32 + (Math.random() * (canvas.height - 64));

	//if both balloons in same position, rechoose balloon2
	if (trump.x <= (sanders.x + 32) && sanders.x <= (trump.x + 32) && trump.y <= (sanders.y + 32) && sanders.y <= (trump.y + 32)) {
		sanders.x = 32 + (Math.random() * (canvas.width - 64));
		sanders.y = 32 + (Math.random() * (canvas.height - 64));
	}
};

// Draw everything
var render = function () {
	//draw images into given positions
	if (bgReady) {ctx.drawImage(bgImage, 0, 0);}
	if (eagleReadyL && flipped) {ctx.drawImage(eagleImageL, eagle.x, eagle.y);}
	if (eagleReadyR && !flipped) {ctx.drawImage(eagleImageR, eagle.x, eagle.y);}
	if (trumpReady) {ctx.drawImage(trumpImage, trump.x, trump.y);}
	if (sandersReady) {ctx.drawImage(sandersImage, sanders.x, sanders.y);}

	//if lives left
	if(livesCounter >= 0 && trumpsTrumped < 50) {
		//score keeper text
		ctx.fillStyle = "rgb(250, 250, 250)";
		ctx.font = "24px Helvetica";
		ctx.textAlign = "left";
		ctx.textBaseline = "top";
		ctx.fillText("Trumps trumped " + trumpsTrumped, 32, 32);

		//life keeper text
		ctx.fillStyle = "rgb(250, 250, 250)";
		ctx.font = "24px Helvetica";
		ctx.textAlign = "right";
		ctx.textBaseline = "top";
		ctx.fillText("Lives " + livesCounter, 480, 32);
	}
    	else if(trumpsTrumped >= 50 && livesCounter >= 0) {
	    ctx.fillStyle = "rgb(250, 0, 0)";
	    ctx.font = "22px Helvetica";
	    ctx.textAlign = "left";
	    ctx.textBaseline = "top";
	    ctx.fillText("CONGRATULATIONS", 140, 32);

	    ctx.fillStyle = "rgb(250, 0, 0)";
	    ctx.font = "22px Helvetica";
	    ctx.textAlign = "left";
	    ctx.textBaseline = "top";
	    ctx.fillText("YOU SAVED ALL 50 STATES FROM TRUMP", 30, 64);

	    livesCounter= -1;
    }   
	//if no lives left
	else {
		ctx.fillStyle = "rgb(250, 0, 0)";
		ctx.font = "24px Helvetica";
		ctx.textAlign = "left";
		ctx.textBaseline = "top";
		ctx.fillText("GAME OVER", 32, 32);
	}
};

// The main game loop
var main = function () {
	var now = Date.now();
	var delta = now - then;
	update(delta / 1000);
	render();
	then = now;
	//don't rerun animation if no lives left
	if(livesCounter >= 0) {
		// Request to do this again ASAP
		requestAnimationFrame(main);
	}
};

// Cross-browser support for requestAnimationFrame
var w = window;
requestAnimationFrame = w.requestAnimationFrame || w.webkitRequestAnimationFrame || w.msRequestAnimationFrame || w.mozRequestAnimationFrame;

// Let's play this game!
var then = Date.now();
reset();
main();
