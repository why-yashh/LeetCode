class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinked = 0;
        int eb = 0; 
        
        while (numBottles > 0) {
            drinked += numBottles;  
            eb += numBottles;        // get empty bottles
            
            numBottles = eb / numExchange; // exchange empties for new bottles
            eb = eb % numExchange;         // leftover empties
        }
        return drinked;
    }
}