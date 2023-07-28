impl Solution {
    pub fn gcd_sort(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        let n = nums.len();
        let mut parent = vec![-1; 100001];
        let mut size = vec![1; 100001];
        for i in 2..100001 {
            if parent[i] == -1 {
                for j in (i..100001).step_by(i) {
                    parent[j] = i as i32;
                }
            }
        }
        for i in 0..n {
            for j in i + 1..n {
                if Solution::gcd(nums[i], nums[j]) > 1 {
                    let p1 = Solution::find(&mut parent, nums[i]);
                    let p2 = Solution::find(&mut parent, nums[j]);
                    if p1 != p2 {
                        if size[p1 as usize] < size[p2 as usize] {
                            parent[p1 as usize] = p2;
                            size[p2 as usize] += size[p1 as usize];
                        } else {
                            parent[p2 as usize] = p1;
                            size[p1 as usize] += size[p2 as usize];
                        }
                    }
                }
            }
        }
        nums.sort();
        for i in 0..n {
            if Solution::find(&mut parent, nums[i]) != Solution::find(&mut parent, nums[0]) {
                return false;
            }
        }
        true
    }
    fn gcd(a: i32, b: i32) -> i32 {
        if b == 0 {
            a
        } else {
            Solution::gcd(b, a % b)
        }
    }
    fn find(parent: &mut Vec<i32>, x: i32) -> i32 {
        if parent[x as usize] == x {
            x
        } else {
            let root = Solution::find(parent, parent[x as usize]);
            parent[x as usize] = root;
            root
        }
    }
}