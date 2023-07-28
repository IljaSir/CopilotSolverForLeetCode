impl Solution {
    pub fn closest_primes(left: i32, right: i32) -> Vec<i32> {
        
        let mut primes = vec![];
        let mut nums = vec![];
        for i in left..=right {
            if i == 1 {
                continue;
            }
            let mut is_prime = true;
            for j in 2..i {
                if i % j == 0 {
                    is_prime = false;
                    break;
                }
            }
            if is_prime {
                primes.push(i);
            } else {
                nums.push(i);
            }
        }
        if primes.is_empty() {
            return vec![-1, -1];
        }
        let mut min = (0, 0);
        for i in 0..primes.len() - 1 {
            if i == 0 {
                min = (i, i + 1);
            }
            if primes[i + 1] - primes[i] < primes[min.1] - primes[min.0] {
                min = (i, i + 1);
            }
        }
        vec![primes[min.0], primes[min.1]]
    }
}