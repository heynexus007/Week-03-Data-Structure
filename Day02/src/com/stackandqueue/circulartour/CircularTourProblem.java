package com.stackandqueue.circulartour;

public class CircularTourProblem {
    static class PetrolPump {
        int petrol, distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int getStartingPoint(PetrolPump[] pumps) {
        int start = 0, deficit = 0, surplus = 0;

        for (int i = 0; i < pumps.length; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;
            if (surplus < 0) {
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }
        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(2, 3),
                new PetrolPump(4, 5),
                new PetrolPump(1, 8),
                new PetrolPump(2, 6)
        };
        int startIndex = getStartingPoint(pumps);
        System.out.println(startIndex);
    }
}
