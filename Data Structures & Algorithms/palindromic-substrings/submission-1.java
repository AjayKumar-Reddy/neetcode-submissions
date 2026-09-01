class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int ans=0;
        for(int indx=0;indx<n-1;indx++){
            int l=indx;
            int r=indx;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                ans++;
                l--;
                r++;
            }
            l=indx;
            r=indx+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                ans++;
                l--;
                r++;
            }

        }
        return ans+1;
    }

    
}
