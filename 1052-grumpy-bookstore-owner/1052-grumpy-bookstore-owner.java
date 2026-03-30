class Solution {
    public int maxSatisfied(int[] arr, int[] grumpy, int minutes) {
        int uncount=0;
        int n=grumpy.length;
        int maxuncount=0;
        int i=0,j=minutes-1;
        int a= i;
        int b=j;
        for(int x=i;x<=j;x++){
            if(grumpy[x]==1) uncount+=arr[x];
        }
        while(j<n){
            if(maxuncount<uncount){
                maxuncount=uncount;
                a=i;b=j;
            }
            i++;j++;
            if(j<n && grumpy[j]==1) uncount+=arr[j];
            if(grumpy[i-1]==1) uncount-=arr[i-1];
        }
        for(int x=a;x<=b;x++){
            grumpy[x]= 0;
        }
        int count=0;
        for(int x=0;x<n;x++){
           if (grumpy[x]==0) count+=arr[x];
        }
        return count;

    }
}