impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        

        let mut set = std::collections::HashSet::new();
        for num in nums {
            set.insert(num);
        }
        let mut max = 0;
        for num in set {
            if !set.contains(&(num - 1)) {
                let mut cur = num + 1;
                while set.contains(&cur) {
                    cur += 1;
                }
                max = max.max(cur - num);
            }
        }
        max
    }
}