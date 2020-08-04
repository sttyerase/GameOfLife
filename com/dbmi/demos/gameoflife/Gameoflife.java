package com.dbmi.demos.gameoflife;

public class Gameoflife{
   public static void main(String[] args) {
      int bsize = 30;
      try{ // 01
         if (args.length == 1) bsize = Integer.parseInt(args[0]);
      }catch (NumberFormatException nfe){
         System.out.println("Bad argument: " + args[0] + ".  Caught NumberFormatException: " + nfe + "\n    Default size substituted: " + bsize);
         bsize = 20;
      } // TRY-CATCH 01
      GOLModel myModel = new GOLModel(bsize);
      GOLView  myView  = new GOLView(myModel);
      GOLController myController = new GOLController(myModel, myView);
   } // MAIN(STRING[])
} // CLASS

//TODO: Implement backstep.

