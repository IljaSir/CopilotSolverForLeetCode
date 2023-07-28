impl Solution {
    pub fn single_number(nums: Vec<i32>) -> i32 {
        

        let mut set = std::collections::HashSet::new();
        let mut sum = 0;
        for n in nums {
            if !set.contains(&n) {
                set.insert(n);
                sum += n;
            }
        }
        sum * 3 - nums.iter().sum::<i32>()
    }
}