impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let n = nums.len();
        let mut uf = UnionFind::new(n);
        let mut uf2 = UnionFind::new(n);
        let mut nums2 = nums.clone();
        let mut idx = vec![0; n];
        for i in 0..n {
            idx[i] = i;
        }
        nums2.sort();
        for i in 0..n {
            for j in i+1..n {
                if Self::gcd(nums2[i], nums2[j]) > 1 {
                    uf.union(i, j);
                }
            }
        }
        for i in 0..n {
            for j in i+1..n {
                if Self::gcd(nums[i], nums[j]) > 1 {
                    uf2.union(i, j);
                }
            }
        }
        for i in 0..n {
            if uf.find(i) != uf2.find(i) {
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