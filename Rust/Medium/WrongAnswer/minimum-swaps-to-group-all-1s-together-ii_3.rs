impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let mut ones: Vec<usize> = Vec::new();
        for (i, v) in nums.iter().enumerate() {
            if *v == 1 {
                ones.push(i);
            }
        }
        if ones.len() == 0 {
            return 0;
        }
        let mut max_ones = 0;
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while j < ones.len() {
            if ones[j] - ones[i] <= nums.len() - 1 {
                count += 1;
                j += 1;
            } else {
                count -= 1;
                i += 1;
            }
            max_ones = max_ones.max(count);
        }
        (ones.len() - max_ones) as i32
    }
}