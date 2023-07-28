class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        int s1_count[26] = {0};
        int s2_count[26] = {0};
        for (auto c: s1) {
            s1_count[c-'a']++;
        }
        for (auto c: s2) {
            s2_count[c-'a']++;
        }
        int s1_count_sum = 0;
        int s2_count_sum = 0;
        for (int i = 0; i < 26; i++) {
            s1_count_sum += s1_count[i];
            s2_count_sum += s2_count[i];
            if (s1_count_sum >= s2_count_sum) {
                if (s1_count_sum > s2_count_sum) {
                    for (int j = i+1; j < 26; j++) {
                        if (s1_count[j] > 0) {
                            return false;
                        }
                    }
                }
            } else {
                for (int j = i+1; j < 26; j++) {
                    if (s2_count[j] > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};