
class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long counter = 0;
        Double ratio = 0.0;
        Map<Double, Integer> freqByFraction = new HashMap<>();
        for(int[] rectangle : rectangles) {
            ratio = (Double.valueOf(rectangle[0]) / Double.valueOf(rectangle[1]));
            counter += freqByFraction.getOrDefault(ratio, 0);
            freqByFraction.put(ratio, (freqByFraction.getOrDefault(ratio, 0) + 1));
        }
        return counter;
    }
}