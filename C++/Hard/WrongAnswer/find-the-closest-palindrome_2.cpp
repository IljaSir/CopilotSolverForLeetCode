class Solution {
public:
    string nearestPalindromic(string n) {
        
        int len = n.length();
        if (len == 1) {
            return to_string(stoi(n) - 1);
        }
        int mid = len / 2;
        string left = n.substr(0, mid);
        int leftNum = stoi(left);
        vector<string> candidates = {to_string(leftNum - 1), to_string(leftNum), to_string(leftNum + 1)};
        for (int i = 0; i < candidates.size(); i++) {
            string candidate = candidates[i];
            string candidateMirror = candidate + (len % 2 == 0 ? "" : string(1, candidate[mid])) + string(candidate.rbegin(), candidate.rend() - (len % 2 == 0 ? 0 : 1));
            candidates[i] = candidateMirror;
        }
        string nMirror = n.substr(0, (len + 1) / 2) + string(n.rbegin(), n.rend() - (len % 2 == 0 ? 0 : 1));
        long diff = LONG_MAX;
        string res = "";
        for (string candidate : candidates) {
            if (candidate == nMirror) {
                continue;
            }
            long candidateNum = stol(candidate);
            long candidateDiff = abs(candidateNum - stol(nMirror));
            if (candidateDiff < diff) {
                diff = candidateDiff;
                res = candidate;
            } else if (candidateDiff == diff) {
                res = min(res, candidate);
            }
        }
        return res;
    }
};