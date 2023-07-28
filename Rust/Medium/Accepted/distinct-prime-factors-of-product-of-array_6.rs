impl Solution {
    pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut seen = vec![false; 1001];
        for num in nums {
            let mut num = num;
            for i in 2..=num {
                if num % i == 0 {
                    while num % i == 0 {
                        num /= i;
                    }
                    if !seen[i as usize] {
                        count += 1;
                        seen[i as usize] = true;
                    }
                }
            }
        }
        count
    }
}