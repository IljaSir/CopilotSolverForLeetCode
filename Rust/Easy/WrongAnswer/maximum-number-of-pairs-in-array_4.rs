impl Solution {
    pub fn number_of_pairs(nums: Vec<i32>) -> Vec<i32> {
        
        let mut count = [0; 101];
        for &n in &nums {
            count[n as usize] += 1;
        }
        let mut pairs = 0;
        let mut leftover = 0;
        for i in 1..=100 {
            for j in i..=100 {
                if i == j {
                    let n = count[i];
                    pairs += n * (n - 1) / 2;
                } else {
                    pairs += count[i] * count[j];
                }
            }
            leftover += count[i] % 2;
        }
        vec![pairs, leftover]
    }
}