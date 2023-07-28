class Solution {
public:
    int countDaysTogether(string arriveAlice, string leaveAlice, string arriveBob, string leaveBob) {
        
        int a1 = stoi(arriveAlice.substr(0,2));
        int a2 = stoi(arriveAlice.substr(3,2));
        int b1 = stoi(leaveAlice.substr(0,2));
        int b2 = stoi(leaveAlice.substr(3,2));
        int c1 = stoi(arriveBob.substr(0,2));
        int c2 = stoi(arriveBob.substr(3,2));
        int d1 = stoi(leaveBob.substr(0,2));
        int d2 = stoi(leaveBob.substr(3,2));
        int a = a1*30+a2;
        int b = b1*30+b2;
        int c = c1*30+c2;
        int d = d1*30+d2;
        int s = max(a,c);
        int e = min(b,d);
        if(s>e) return 0;
        return e-s+1;
    }
};