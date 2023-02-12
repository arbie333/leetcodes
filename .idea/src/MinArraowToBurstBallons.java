import java.util.Arrays;

class MinArraowToBurstBallons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by the second values in points
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) return 0;
            if (o1[1] < o2[1]) return -1;
            return 1;
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }
}