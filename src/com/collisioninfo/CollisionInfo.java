package com.collisioninfo;

import java.io.*;
import java.util.ArrayList;

/**
 * this class can be used to read file and call CollisionList to get a series of computing info and final write the result to file
 *
 * @author wenyi shen
 * @version 1.0
 */
public class CollisionInfo {


    /**
     * this is the main method that process inputStream and call CollisionList to get a series of task and write the information to file
     *
     * @param args your input file and  end with .csv
     */
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Error: missing name of the input file");
            System.exit(0);
        } else {
            for (String path : args) {
                System.out.println(path);

                if (!path.endsWith(".csv")) {
                    System.out.println("it is not a csv file");
                    System.exit(0);
                }

                File inFile = new File(path); // 读取的CSV文件
                String inString = "";
                ArrayList<Collision> collisionArrayList = new ArrayList<>();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(inFile));
                    reader.readLine();
                    while ((inString = reader.readLine()) != null) {
                        String[] data = inString.split(",");
                        if (data.length == 21) {
                            //System.out.println(count);
                            Collision collision = new Collision();
                            collision.setDate(data[0]);
                            collision.setTime(data[1]);
                            collision.setBorough(data[2]);
                            collision.setZIPcode(data[3]);
                            collision.setLattitude(data[4]);
                            collision.setLongitude(data[5]);
                            collision.setOnstreetname(data[6]);
                            collision.setCrossstreetname(data[7]);
                            collision.setNumberofpersonsinjured(data[8]);
                            collision.setNumberofpersonskilled(data[9]);
                            collision.setNumberofpedestriansinjured(data[10]);
                            collision.setNumberofpedestrianskilled(data[11]);
                            collision.setNumberofcyclistsinjured(data[12]);
                            collision.setNumberofcyclistskilled(data[13]);
                            collision.setNumberofmotoristsinjured(data[14]);
                            collision.setNumberofmotoristskilled(data[15]);
                            collision.setContributingfactorvehicle1(data[16]);
                            collision.setContributingfactorvehicle2(data[17]);
                            collision.setUniquekey(data[18]);
                            collision.setVehicletypecode1(data[19]);
                            collision.setVehicletypecode2(data[20]);

                            if (collision.getZIPcode() != null || !"\"\"".equals(collision.getZIPcode())) {
                                collisionArrayList.add(collision);
                            }
                        }
                    }
                    reader.close();


                    CollisionList collisionList = new CollisionList();
                    String largestCollision = collisionList.findTheThreeZipCodesWithTheLargestNumberOfCollisions(collisionArrayList);
                    String smallCollisions = collisionList.findTheThreeZipCodesWithTheSmallestNumberOfCollisions(collisionArrayList);
                    String mostInjuries = collisionList.findTheThreeZipCodesThathaveTheMostInjuriesAndFatalities(collisionArrayList);
                    String mostDangerousCyclist = collisionList.findTheThreeZipCodesThatAreMostDangerousForTheCyclists(collisionArrayList);
                    String percentge = collisionList.findThePercentageOfCollisionsInvolvingTheFollowingVehicleTypes(collisionArrayList);

                    String pathname = path.substring(0, path.length() - 4);
                    String outFileName = pathname + ".out";

                    File outputFile = new File(outFileName);

                    try {
                        if (!outputFile.exists()) {
                            outputFile.createNewFile();
                        }
                    } catch (Exception e) {
                        System.out.println("Error: cannot create file :" + outFileName);
                    }
                    FileWriter fileWriter = new FileWriter(outputFile, false);
                    fileWriter.write(largestCollision);
                    fileWriter.write(smallCollisions);
                    fileWriter.write(mostInjuries);
                    fileWriter.write(mostDangerousCyclist);
                    fileWriter.write(percentge);
                    fileWriter.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("Error: file " + path + " does not exist");
                } catch (IOException ex) {
                    System.out.println("read file:" + path + " error! ");
                }
            }
        }


    }

}
