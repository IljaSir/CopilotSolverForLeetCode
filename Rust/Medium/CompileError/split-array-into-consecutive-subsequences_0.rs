impl Solution {
    pub fn is_possible(nums: Vec<i32>) -> bool {
        

        let mut count: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        let mut tails: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for num in nums {
            *count.entry(num).or_insert(0) += 1;
        }
        for num in nums {
            if *count.entry(num).or_insert(0) == 0 {
                continue;
            }
            if *tails.entry(num).or_insert(0) > 0 {
                *tails.entry(num).or_insert(0) -= 1;
                *tails.entry(num + 1).or_insert(0) += 1;
            } else if *count.entry(num + 1).or_insert(0) > 0 && *count.entry(num + 2).or_insert(0) > 0 {
                *count.entry(num + 1).or_insert(0) -= 1;
                *count.entry(num + 2).or_insert(0) -= 1;
                *tails.entry(num + 3).or_insert(0) += 1;
            } else {
                return false;
            }
            *count.entry(num).or_insert(0) -= 1;
        }
        true
    }
}