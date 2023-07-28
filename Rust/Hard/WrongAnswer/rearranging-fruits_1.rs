impl Solution {
    pub fn min_cost(basket1: Vec<i32>, basket2: Vec<i32>) -> i64 {
        
        let mut b1 = basket1.clone();
        let mut b2 = basket2.clone();
        b1.sort();
        b2.sort();
        
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut res = std::i64::MAX;
        while i < b1.len() && j < b2.len() {
            if b1[i] == b2[j] {
                res = res.min(b1[i] as i64 + b2[j] as i64);
                i += 1;
                j += 1;
            } else if b1[i] < b2[j] {
                i += 1;
            } else {
                j += 1;
            }
        }
        
        let mut sum = 0;
        let mut i = 0;
        let mut j = 0;
        while i < basket1.len() && j < basket2.len() {
            if basket1[i] == basket2[j] {
                sum += basket1[i] as i64;
                i += 1;
                j += 1;
            } else if basket1[i] < basket2[j] {
                i += 1;
            } else {
                j += 1;
            }
        }
        
        if res == std::i64::MAX {
            return -1;
        }
        res.min(sum)
    }
}