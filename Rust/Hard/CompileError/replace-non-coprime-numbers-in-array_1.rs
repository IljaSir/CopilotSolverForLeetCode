impl Solution {
    pub fn replace_non_coprimes(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![0; nums.len()];
        let mut primes = vec![0; 100001];
        for i in 2..=100000 {
            if primes[i] == 0 {
                for j in (i..=100000).step_by(i) {
                    primes[j] = i;
                }
            }
        }
        let mut lcms = vec![0; 100001];
        for i in 1..=100000 {
            if primes[i] == i {
                lcms[i] = i;
            } else {
                lcms[i] = lcms[i / primes[i]] * primes[i];
            }
        }
        let mut map = std::collections::HashMap::new();
        for i in (0..nums.len()).rev() {
            let n = nums[i];
            if map.contains_key(&n) {
                result[i] = *map.get(&n).unwrap();
            } else {
                result[i] = -1;
            }
            if i > 0 {
                let n = lcms[nums[i - 1] as usize];
                if map.contains_key(&n) {
                    map.insert(n, i - 1);
                } else {
                    map.insert(n, i - 1);
                }
            }
        }
        result
    }
}