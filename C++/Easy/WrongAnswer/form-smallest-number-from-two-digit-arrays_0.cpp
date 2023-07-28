class Solution {
public:
    int minNumber(vector<int>& nums1, vector<int>& nums2) {
        
        string s1;
        string s2;
        for (int i = 0; i < nums1.size(); i++) {
            s1 += to_string(nums1[i]);
        }
        for (int i = 0; i < nums2.size(); i++) {
            s2 += to_string(nums2[i]);
        }
        sort(s1.begin(), s1.end());
        sort(s2.begin(), s2.end());
        int i = 0;
        int j = 0;
        string res;
        while (i < s1.size() && j < s2.size()) {
            if (s1[i] < s2[j]) {
                res += s1[i];
                i++;
            } else if (s1[i] > s2[j]) {
                res += s2[j];
                j++;
            } else {
                int ii = i;
                int jj = j;
                while (ii < s1.size() && jj < s2.size() && s1[ii] == s2[jj]) {
                    ii++;
                    jj++;
                }
                if (ii < s1.size() && jj < s2.size()) {
                    if (s1[ii] < s2[jj]) {
                        res += s1[i];
                        i++;
                    } else {
                        res += s2[j];
                        j++;
                    }
                } else if (ii < s1.size()) {
                    res += s1[i];
                    i++;
                } else {
                    res += s2[j];
                    j++;
                }
            }
        }
        while (i < s1.size()) {
            res += s1[i];
            i++;
        }
        while (j < s2.size()) {
            res += s2[j];
            j++;
        }
        return stoi(res);
    }
};