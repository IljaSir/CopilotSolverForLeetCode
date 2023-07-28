impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut even_count = std::collections::HashMap::new();
        for n in nums {
            if n % 2 == 0 {
                *even_count.entry(n).or_insert(0) += 1;
            }
        }
        if even_count.len() == 0 {
            return -1;
        }
        let mut max_count = 0;
        let mut max_num = 0;
        for (k, v) in even_count.iter() {
            if *v > max_count {
                max_count = *v;
                max_num = *k;
            } else if *v == max_count {
                max_num = std::cmp::min(max_num, *k);
            }
        }
        max_num
    }
}