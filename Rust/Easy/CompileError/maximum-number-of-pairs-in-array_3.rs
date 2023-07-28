impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut count = vec![0; 101];
        for num in nums {
            count[num as usize] += 1;
        }
        let mut ans = 0;
        for i in 0..=100 {
            for j in i..=100 {
                if i == j {
                    ans += count[i] * (count[i] - 1) / 2;
                } else {
                    ans += count[i] * count[j];
                }
            }
        }
        vec![ans, nums.len() as i32 - ans]
    }
}