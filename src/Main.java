

public class Main {
    public static void main(String[] args) {

        // the speed limit next to my house is 60km/h
        // we integrate with dt = 1s to find the distance traversed a vehicle with the given velocities.

        // size of the array (number of velocity measurements)
        int size = 100;

        // speed limit
        int speed_limit = 60;

        // velocities given in km/h
        float[] velocities = new float[size];

        // the vehicle accelerates for the first 6 seconds
        velocities[0] = 50;
        velocities[1] = 52;
        velocities[2] = 54;
        velocities[3] = 56;
        velocities[4] = 58;

        // the vehicle reaches the speed limit and maintains it for the rest of its journey.
        for (int i = 5; i < size; i++) {
            velocities[i] = speed_limit;
        }

        for (int i = 0; i < size; i++) {
            velocities[i] = toKilometersPerSecond(velocities[i]);
        }

        // time interval
        int ds = 1;

        // variable where we append the cumulative sums
        float distance_traveled = 0;

        int lower_bound = 0;
        int upper_bound = 5;

        // integrate each velocity with respect to ds
        for (int s = lower_bound; s <= upper_bound; s++) {
            distance_traveled += ds*velocities[s];
        }

        // convert to distance traveled to meters if the distance is less than 0.1km (100m) and print with correct
        // formating

        float conversion_threshold = 0.1F;

        if (distance_traveled < conversion_threshold) {
            distance_traveled = toMeters(distance_traveled);
            System.out.println("Distance traveled after "+ upper_bound + " seconds: " + distance_traveled + "m");
        } else {
            System.out.println("Distance traveled after "+ upper_bound + " seconds: " + distance_traveled + "km");
        }
    }

    public static float toMeters(float distance_traveled) {
        return distance_traveled/1000;
    }

    public static float toKilometersPerSecond (float velocity) {
        return velocity / 3600;
    }
}