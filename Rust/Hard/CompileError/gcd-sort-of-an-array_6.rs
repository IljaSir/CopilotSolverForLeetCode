impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let n = nums.len();
        let mut uf = UnionFind::new(n);
        let mut a = vec![0; 100001];
        for i in 0..n {
            for j in 2..=nums[i].sqrt() as usize {
                if nums[i] % j as i32 == 0 {
                    if a[j] != 0 {
                        uf.union(i, a[j] as usize);
                    }
                    a[j] = i as i32 + 1;
                    if a[nums[i] as usize / j] != 0 {
                        uf.union(i, a[nums[i] as usize / j] as usize);
                    }
                    a[nums[i] as usize / j] = i as i32 + 1;
                }
            }
        }
        nums.sort();
        for i in 0..n {
            if uf.find(i) != uf.find(nums[i] as usize - 1) {
                return false;
            }
        }
        true
    }
}