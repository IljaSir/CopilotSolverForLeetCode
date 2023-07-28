impl Solution {
    pub fn distinct_prime_factors(nums: Vec<i32>) -> i32 {
        
        let mut factors = vec![];
        for num in nums {
            factors.push(Self::get_factors(num));
        }
        let mut res = 0;
        for i in 2..=1000 {
            let mut found = false;
            for factor in &factors {
                if factor.contains(&i) {
                    found = true;
                    break;
                }
            }
            if found {
                res += 1;
            }
        }
        res
    }
    fn get_factors(num: i32) -> Vec<i32> {
        let mut factors = vec![];
        let mut n = num;
        let mut i = 2;
        while i * i <= n {
            if n % i == 0 {
                factors.push(i);
                while n % i == 0 {
                    n /= i;
                }
            }
            i += 1;
        }
        if n > 1 {
            factors.push(n);
        }
        factors
    }
}