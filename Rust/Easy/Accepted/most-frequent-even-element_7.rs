impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut freq = std::collections::HashMap::new();
        for x in nums {
            if x % 2 == 0 {
                let count = freq.entry(x).or_insert(0);
                *count += 1;
            }
        }
        let mut max = 0;
        let mut res = -1;
        for (k, v) in freq {
            if v > max {
                max = v;
                res = k;
            } else if v == max && k < res {
                res = k;
            }
        }
        res
    }
}