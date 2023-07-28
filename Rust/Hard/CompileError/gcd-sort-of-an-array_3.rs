impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let n = nums.len();
        let mut uf = UnionFind::new(n);
        let mut indices = vec![0; 100_001];
        for i in 0..n {
            let x = nums[i];
            if indices[x as usize] != 0 {
                uf.union(i, indices[x as usize] - 1);
            }
            indices[x as usize] = i + 1;
            for j in 2..=x / 2 {
                if x % j == 0 {
                    if indices[j as usize] != 0 {
                        uf.union(i, indices[j as usize] - 1);
                    }
                    if indices[(x / j) as usize] != 0 {
                        uf.union(i, indices[(x / j) as usize] - 1);
                    }
                }
            }
        }
        nums.sort_unstable();
        for i in 0..n {
            if uf.find(i) != uf.find(nums[i] as usize - 1) {
                return false;
            }
        }
        true
    }
}