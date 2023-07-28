impl Solution {
    pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for x in nums.iter() {
            if *x > max {
                max = *x;
            }
        }
        let mut prime = vec![0; max as usize + 1];
        for i in 2..=max {
            if prime[i as usize] == 0 {
                prime[i as usize] = i;
                let mut j = i * i;
                while j <= max {
                    if prime[j as usize] == 0 {
                        prime[j as usize] = i;
                    }
                    j += i;
                }
            }
        }
        let mut res = 0;
        let mut factors = std::collections::HashSet::new();
        for x in nums.iter() {
            let mut y = *x;
            while y > 1 {
                let p = prime[y as usize];
                if !factors.contains(&p) {
                    res += 1;
                    factors.insert(p);
                }
                while y % p == 0 {
                    y /= p;
                }
            }
            factors.clear();
        }
        res
    }
}