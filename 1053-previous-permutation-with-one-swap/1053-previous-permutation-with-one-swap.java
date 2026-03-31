class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int l = arr.length, index = -1,min=Integer.MAX_VALUE,n=-1;
        for (int i = l - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1)
            return arr;
        else {
            for (int i = index+1; i < l; i++) {
                if (arr[i] < arr[index] && min>arr[index]-arr[i]) {
                    min=arr[index]-arr[i];
                    n=i;
                }
            }
            int temp=arr[n];
            arr[n]=arr[index];
            arr[index]=temp;
        }
        return arr;
    }
}