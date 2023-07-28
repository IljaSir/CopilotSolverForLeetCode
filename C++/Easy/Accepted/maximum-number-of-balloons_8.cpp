class Solution {
public:
    int maxNumberOfBalloons(string text) {
        
        int a[26]={0};
        for(int i=0;i<text.size();i++)
        {
            a[text[i]-'a']++;
        }
        int m=1000000;
        m=min(m,a['b'-'a']);
        m=min(m,a['a'-'a']);
        m=min(m,a['l'-'a']/2);
        m=min(m,a['o'-'a']/2);
        m=min(m,a['n'-'a']);
        return m;
    }
};