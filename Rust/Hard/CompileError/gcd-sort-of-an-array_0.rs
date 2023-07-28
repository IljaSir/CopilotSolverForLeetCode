impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let n = nums.len();
        let mut uf = UnionFind::new(100001);
        for i in 0..n {
            for j in (i + 1)..n {
                if Self::gcd(nums[i], nums[j]) > 1 {
                    uf.union(nums[i] as usize, nums[j] as usize);
                }
            }
        }
        nums.sort();
        for i in 1..n {
            if uf.find(nums[i] as usize) != uf.find(nums[i - 1] as usize) {
                return false;
            }
        }
        true
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Self::gcd(b, a % b)
        }
    }
}