class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] countArray = new int[26];
        int Totalcount =0;

        for(char c : chars.toCharArray()){
            countArray[c - 'a']++;
        }

        for(String word : words){
            int[] temp = countArray.clone();

            boolean canform = true;

            for(char c: word.toCharArray()){
                if(temp[c-'a']==0){
                    canform = false;
                    break;
                }
                temp[c-'a']--;
            }
            if(canform){
                Totalcount += word.length();
            }
        }
        return Totalcount;
            
    }
}