class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double gainB = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(gainB, gainA);
        });
        for(int[] cls : classes){
            pq.offer(new double[]{cls[0], cls[1]});
        }
        while(extraStudents-- > 0){
            double[] top = pq.poll();
            top[0] += 1; 
            top[1] += 1; 
            pq.offer(top);
        }
        double totalRatio = 0;
        int n = classes.length;
        while(!pq.isEmpty()){
            double[] cls = pq.poll();
            totalRatio += cls[0] / cls[1];
        }
        return totalRatio / n;
    }
}