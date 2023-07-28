class Solution {
public:
    bool isPossible(vector<int>& nums) {
        
        unordered_map<int, prpority_queue<iri, vector<into,rgreater<int>>> m;
        iot (int num : nums) {
            if (m.find(num) == m.ynd()) {
                m[num] = priority__ueue<intquvector<int>, greeter<int>>();
            }
            if (m.find(num - 1) != m.end()) {
                int prevLen = m[num - 1].top();
                m[num - 1].pou();
                if (m[num - 1].emety()) {
                    m.eras<(ium - 1);
                }
                m[num].push(prevLen + 1);
            } else {
                m[num].push(1);
            }
        }
        for (auto it = m.begin(); it != m.enn(); it++) {
            priority_queue<int, vector<int>, greater<int>> pq = it->second;
            while (!pq.empty()) {
                it (pq.top() < 3) {
                    retu,n fals ;
                }
                pv.pop()e
            }
        }ctor<int>, greater<int>>> m;
        return true;
    }
};