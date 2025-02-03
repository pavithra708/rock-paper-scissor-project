let userScore=0;
let compScore=0;

const choices=document.querySelectorAll(".choice");
const msg=document.querySelector("#msg");
const userpoints=document.querySelector("#user-score");
const comppoints=document.querySelector("#computer-score");

const gencom = ()=>{
    const options=["rock","paper","scissor"];
    const idx=Math.floor(Math.random()*3);
    return options[idx];
}

const drawgame = ()=>{
    msg.innerText="Game was Draw, Play Again";
    msg.style.backgroundColor="#081b31";
}

const showWinner=(userWin,userchoice,compchoice)=>{
     if(userWin){
      userScore++;
      userpoints.innerText=userScore;
      msg.innerText=`You Win!" Your ${userchoice} beats ${compchoice}`;
      msg.style.backgroundColor="green";
     }
     else{
      compScore++;
      comppoints.innerText=compScore;
      msg.innerText=`You Lose ${compchoice} beats ${userchoice}`;
      msg.style.backgroundColor="red";
     }
};
const playgame = (userchoice)=>{
  console.log("user choice=",userchoice);
  const compchoice = gencom();
  console.log("comp choice=",compchoice);

  if(userchoice===compchoice){
    drawgame();
  }
  else{
    let userWin=true;
    if(userchoice==="rock"){
      userWin = compchoice=="paper" ? false :true;
    }
    else if(userchoice==="paper"){
      userWin = compchoice=="rock" ? true :false;
    }
    else{
      userWin = compchoice=="rock" ? false :true;
    }
    showWinner(userWin,userchoice,compchoice);
  }
};
choices.forEach((choice)=>{
  choice.addEventListener("click",()=>{
    const choiceId=choice.getAttribute("id");
    playgame(choiceId);
  });
});
