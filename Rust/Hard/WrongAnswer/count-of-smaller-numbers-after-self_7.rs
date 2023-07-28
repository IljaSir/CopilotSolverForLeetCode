impl Solution {
    pub fn count_smaller(nums: Vec<i32>) -> Vec<i32> {
        
        let mut result = vec![0; nums.len()];
        let mut tree = vec![0; nums.len() + 1];
        let mut map = vec![(0, 0); nums.len()];
        for i in 0..nums.len() {
            map[i] = (nums[i], i);
        }
        map.sort();
        for i in 0..nums.len() {
            let index = map[i].1;
            result[index] = Self::query(&tree, index);
            Self::update(&mut tree, index + 1, 1);
        }
        result
    }

    fn update(tree: &mut Vec<i32>, mut index: usize, value: i32) {
        while index < tree.len() {
            tree[index] += value;
            index += index & index.wrapping_neg();
        }
    }

    fn query(tree: &Vec<i32>, mut index: usize) -> i32 {
        let mut sum = 0;
        while index > 0 {
            sum += tree[index];
            index -= index & index.wrapping_neg();
        }
        sum
    }
}