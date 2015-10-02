package com.collisioninfo;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * this class provide five method ,they can computing that five task.
 *
 * @author wenyi shen
 * @version 1.0
 */


public class CollisionList {

    /**
     * this method is Find the three zip codes with the largest number of collisions
     *
     * @param collisions a ArrayList of Collision
     * @return a series of three zip codes with the largest number of collisions
     */
    public String findTheThreeZipCodesWithTheLargestNumberOfCollisions(ArrayList<Collision> collisions) {

        HashSet<String> zipcodes = new HashSet<>();
        for (Collision collision : collisions) {
            zipcodes.add(collision.getZIPcode());
        }
        String[] zip = new String[zipcodes.size()];
        int[] count1 = new int[zipcodes.size()];
        int[] count2 = new int[zipcodes.size()];
        int i = 0, j = 0;
        for (String zipcode : zipcodes) {
            for (Collision collision : collisions) {
                if (collision.getZIPcode().equals(zipcode)) {
                    zip[i] = zipcode;
                    count1[i]++;
                }
            }
            i++;
        }

        for (i = 0; i < zip.length; i++) {
            //System.out.println("zipcode:  " + zip[i] + "  count: " + count1[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < zip.length; i++) {
            count2[i] = count1[i];
        }

        Arrays.sort(count2);

        int max[] = new int[3];
        for (i = count2.length - 1; i >= 0; i--) {
            if (count2[i] != count2[i - 1] && j < 3) {
                max[j] = count2[i];
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        stringBuilder.append("ZIP codes with the largest number of collisions \n");
        for (j = 0; j < max.length; j++) {
            for (i = 0; i < count1.length; i++) {
                if (count1[i] == max[j]) {
                    stringBuilder.append("         " + zip[i] + "       " + count1[i] + "  collisions\n");
                }
            }
        }
        return stringBuilder.toString();


    }

    /**
     * this method is Find the three zip codes with the smallest number of collisions
     *
     * @param collisions a ArrayList of Collision
     * @return a series of three zip codes with the smallest number of collisions
     */
    public String findTheThreeZipCodesWithTheSmallestNumberOfCollisions(ArrayList<Collision> collisions) {

        HashSet<String> zipcodes = new HashSet<>();
        for (Collision collision : collisions) {
            zipcodes.add(collision.getZIPcode());
        }

        String[] zip = new String[zipcodes.size()];
        int[] count1 = new int[zipcodes.size()];
        int[] count2 = new int[zipcodes.size()];
        int i = 0, j = 0;
        for (String zipcode : zipcodes) {
            for (Collision collision : collisions) {
                if (collision.getZIPcode().equals(zipcode)) {
                    zip[i] = zipcode;
                    count1[i]++;
                }
            }
            i++;
        }

        for (i = 0; i < zip.length; i++) {
            //System.out.println("zipcode:  " + zip[i] + "  count: " + count1[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < zip.length; i++) {
            count2[i] = count1[i];
        }

        Arrays.sort(count2);

        int min[] = new int[3];
        for (i = 0; i < count2.length; i++) {
            if (count2[i] != count2[i + 1] && j < 3) {
                min[j] = count2[i];
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        stringBuilder.append("ZIP codes with the smallest number of collisions \n");
        for (j = min.length - 1; j >= 0; j--) {
            for (i = 0; i < count1.length; i++) {
                if (count1[i] == min[j]) {
                    stringBuilder.append("         " + zip[i] + "       " + count1[i] + "  collisions\n");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Find the three zip codes that have the most injuries and fatalities resulting from vehicle collisions (overall for all persons
     * involved).
     *
     * @param collisions a ArrayList of Collision
     * @return a series of three zip codes with the most injuries and fatalities resulting
     */
    public String findTheThreeZipCodesThathaveTheMostInjuriesAndFatalities(ArrayList<Collision> collisions) {

        HashSet<String> zipcodes = new HashSet<>();
        for (Collision collision : collisions) {
            zipcodes.add(collision.getZIPcode());
        }

        String[] zip = new String[zipcodes.size()];
        int[] count1 = new int[zipcodes.size()];
        int[] count2 = new int[zipcodes.size()];
        int i = 0, j = 0;
        for (String zipcode : zipcodes) {
            for (Collision collision : collisions) {
                if (collision.getZIPcode().equals(zipcode)) {
                    zip[i] = zipcode;
                    int number = Integer.parseInt(collision.getNumberofpersonsinjured()) + Integer.parseInt(collision.getNumberofpersonskilled()) +
                            Integer.parseInt(collision.getNumberofpedestriansinjured()) +
                            Integer.parseInt(collision.getNumberofpedestrianskilled()) +
                            Integer.parseInt(collision.getNumberofcyclistsinjured()) +
                            Integer.parseInt(collision.getNumberofcyclistskilled()) +
                            Integer.parseInt(collision.getNumberofmotoristsinjured()) +
                            Integer.parseInt(collision.getNumberofmotoristskilled());


                    count1[i] += number;
                }
            }
            i++;
        }

        for (i = 0; i < zip.length; i++) {
            //System.out.println("zipcode:  " + zip[i] + "  number: " + count1[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < zip.length; i++) {
            count2[i] = count1[i];
        }

        Arrays.sort(count2);

        int max[] = new int[3];
        for (i = count2.length - 1; i >= 0; i--) {
            if (count2[i] != count2[i - 1] && j < 3) {
                max[j] = count2[i];
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        stringBuilder.append("ZIP codes with the most injuries and fatalities (combined): \n");
        for (j = 0; j < max.length; j++) {
            for (i = 0; i < count1.length; i++) {
                if (count1[i] == max[j]) {
                    stringBuilder.append("         " + zip[i] + "       " + count1[i] + "  injuries and fatalities \n");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Find the three zip codes that are most dangerous for the cyclists (i.e., the number of cyclist injuries and fatalities is the largest).
     *
     * @param collisions a ArrayList of Collision
     * @return a series of three zip codes with the most dangerous for the cyclists
     */

    public String findTheThreeZipCodesThatAreMostDangerousForTheCyclists(ArrayList<Collision> collisions) {

        HashSet<String> zipcodes = new HashSet<>();
        for (Collision collision : collisions) {
            zipcodes.add(collision.getZIPcode());
        }

        String[] zip = new String[zipcodes.size()];
        int[] count1 = new int[zipcodes.size()];
        int[] count2 = new int[zipcodes.size()];
        int i = 0, j = 0;
        for (String zipcode : zipcodes) {
            for (Collision collision : collisions) {
                if (collision.getZIPcode().equals(zipcode)) {
                    zip[i] = zipcode;
                    int number =
                            Integer.parseInt(collision.getNumberofcyclistsinjured()) +
                                    Integer.parseInt(collision.getNumberofcyclistskilled());
                    count1[i] += number;
                }
            }
            i++;
        }

        for (i = 0; i < zip.length; i++) {
            System.out.println("zipcode:  " + zip[i] + "  number: " + count1[i]);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (i = 0; i < zip.length; i++) {
            count2[i] = count1[i];
        }

        Arrays.sort(count2);

        int max[] = new int[3];
        for (i = count2.length - 1; i > 0; i--) {
            if (count2[i] != count2[i - 1] && j < 3) {
                max[j] = count2[i];
                j++;
            }
            if (j == 3) {
                break;
            }
        }
        stringBuilder.append("ZIP codes with the most cyclist injuries and fatalities: \n");
        for (j = 0; j < max.length; j++) {
            for (i = 0; i < count1.length; i++) {
                if (count1[i] == max[j]) {
                    stringBuilder.append("         " + zip[i] + "       " + count1[i] + " cyclists hurt \n");
                }
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Find the percentage of collisions involving the following vehicle types:
     * taxi
     * bus
     * bicycle
     * fire truck
     * ambulance
     *
     * @param collisions a ArrayList of Collision
     * @return a series of percentage of five vehicle types
     */
    public String findThePercentageOfCollisionsInvolvingTheFollowingVehicleTypes(ArrayList<Collision> collisions) {

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0, j = 0;
        int taix = 0, bus = 0, bicycle = 0, firetruck = 0, ambulance = 0;
        for (Collision collision : collisions) {
            if ("\"TAXI\"".equals(collision.getVehicletypecode1()) || "\"TAXI\"".equals(collision.getVehicletypecode2())) {
                taix++;
            } else if (collision.getVehicletypecode1().equals("\"BUS\"") || collision.getVehicletypecode2().equals("\"BUS\"")) {
                bus++;
            } else if (collision.getVehicletypecode1().equals("\"BICYCLE\"") || collision.getVehicletypecode2().equals("\"BICYCLE\"")) {
                bicycle++;
            } else if (collision.getVehicletypecode1().equals("\"FIRE TRUCK\"") || collision.getVehicletypecode2().equals("\"fire truck\"")) {
                firetruck++;
            } else if (collision.getVehicletypecode1().equals("\"AMBULANCE\"") || collision.getVehicletypecode2().equals("\"AMBULANCE\"")) {
                ambulance++;
            }
        }
        stringBuilder.append("Percentage of collisions involving certain vehicle types: \n");

        System.out.println(taix + "" + collisions.size());
        DecimalFormat df = new DecimalFormat("0.00%");
        double taixPercent = taix * 1.0 / collisions.size();
        double busPercent = bus * 1.0 / collisions.size();
        double bicyclePercent = bicycle * 1.0 / collisions.size();
        double firetruckPercent = firetruck * 1.0 / collisions.size();
        double ambulancePercent = ambulance * 1.0 / collisions.size();
        stringBuilder.append("          taix    " + "   " + df.format(taixPercent) + "\n");
        stringBuilder.append("          bus    " + "   " + df.format(busPercent) + "\n");
        stringBuilder.append("          bicycle    " + "   " + df.format(bicyclePercent) + "\n");
        stringBuilder.append("          fire truck    " + "   " + df.format(firetruckPercent) + "\n");
        stringBuilder.append("          ambulance    " + "   " + df.format(ambulancePercent) + "\n");

        return stringBuilder.toString();
    }

}
