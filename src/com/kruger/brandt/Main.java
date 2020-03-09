package com.kruger.brandt;

import java.util.Arrays;

public class Main {

    static void minimumBribes(int[] q) {

        int numberOfTestCases = q[0];
        int numberPeopleInQueu = q[1];
        int placeInArray = 2;

        System.out.println(Arrays.toString(q));

        for (int j = 1; j <= numberOfTestCases; j++) {

            int[] peopleInQueu = new int[numberPeopleInQueu];

            System.arraycopy(q, placeInArray, peopleInQueu, 0, numberPeopleInQueu);
            placeInArray += numberPeopleInQueu;

            if( placeInArray < q.length){
                numberPeopleInQueu = q[placeInArray];
                placeInArray++;
            }

            int swapps = 0;
            boolean moreThanTwoSwapsforOnePerson = false;

            if( peopleInQueu.length > 100000 || peopleInQueu.length < 1){
                System.out.println("Queu invalid length");
                return;
            }

            for (int i = 0; i < peopleInQueu.length; i++) {

                if (peopleInQueu[i] == i) {
                    continue;
                } else if (peopleInQueu[i] < i) {
                    if (peopleInQueu[i] - i > 2) {
                        moreThanTwoSwapsforOnePerson = true;
                        break;
                    }
                    swapps += (i + 1) - peopleInQueu[i];
                } else {
                    if (peopleInQueu[i] - ( i + 1 ) > 2) {
                        moreThanTwoSwapsforOnePerson = true;
                        break;
                    }

                    swapps += peopleInQueu[i] - (i + 1);
                }
            }

            if (moreThanTwoSwapsforOnePerson == false)
                System.out.println(swapps);
            else
                System.out.println("Too chaotic");

        }
    }

    public static void main(String[] args) {


        int[] g = new int[]{2, 5, 2, 1, 5, 3, 4, 5, 2, 5, 1, 3, 4};

        minimumBribes(g);
    }
}
