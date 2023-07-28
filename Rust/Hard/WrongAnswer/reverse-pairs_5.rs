impl Solution {
    pub fn reverse_pairs(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut nums = nums;
        nums.reverse();
        let mut tree = vec![0; 5 * 10_000 + 1];
        for num in nums {
            res += Self::query(&tree, (num * 2 + 1) as usize);
            Self::update(&mut tree, num as usize);
        }
        res
    }
    fn query(tree: &[i32], idx: usize) -> i32 {
        let mut idx = idx;
        let mut res = 0;
        while idx > 0 {
            res += tree[idx];
            idx -= idx & idx.wrapping_neg();
        }
        res
    }
    fn update(tree: &mut [i32], idx: usize) {
        let mut idx = idx;
        while idx < tree.len() {
            tree[idx] += 1;
            idx += idx & idx.wrapping_neg();
        }
    }
}