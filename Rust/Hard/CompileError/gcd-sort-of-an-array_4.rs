impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        nums.sort();
        let mut uf = UnionFind::new(nums.len());
        let mut primes = vec![vec![]; 100001];
        for i in 2..=100000 {
            if primes[i].is_empty() {
                let mut j = i;
                while j <= 100000 {
                    primes[j].push(i);
                    j += i;
                }
            }
        }
        for i in 0..nums.len() {
            for p in &primes[nums[i] as usize] {
                if let Some(j) = nums.binary_search(&(nums[i] / p)).ok() {
                    uf.union(i, j);
                }
            }
        }
        for i in 0..nums.len() {
            if nums[i] != nums[uf.find(i)] {
                return false;
            }
        }
        true
    }
}