impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        

        let mut set = std::collections::HashSet::new();
        for n in nums {
            set.insert(n);
        }
        let mut max = 0;
        for n in &set {
            if !set.contains(&(n - 1)) {
                let mut curr = n + 1;
                while set.contains(&curr) {
                    curr += 1;
                }
                max = max.max(curr - n);
            }
        }
        max
    }
}