impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut max = 0;
        let mut res = -1;
        for n in nums {
            if n % 2 == 0 {
                *map.entry(n).or_insert(0) += 1;
                if map[&n] > max {
                    max = map[&n];
                    res = n;
                } else if map[&n] == max && n < res {
                    res = n;
                }
            }
        }
        res
    }
}