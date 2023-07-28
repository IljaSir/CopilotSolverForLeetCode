impl Solution {
    pub fn create_sorted_array(instructions: Vec<i32>) -> i32 {
        
        let mut tree = vec![0; 100001];
        let mut ret = 0;
        let mut cost = 0;
        for (i, &x) in instructions.iter().enumerate() {
            let less = Self::count(&tree, x - 1);
            let more = i - Self::count(&tree, x);
            cost += std::cmp::min(less, more);
            cost %= 1000000007;
            Self::update(&mut tree, x);
        }
        cost
    }
    
    fn update(tree: &mut Vec<i32>, mut x: i32) {
        while x < 100001 {
            tree[x as usize] += 1;
            x += x & -x;
        }
    }
    
    fn count(tree: &Vec<i32>, mut x: i32) -> i32 {
        let mut ret = 0;
        while x > 0 {
            ret += tree[x as usize];
            x -= x & -x;
        }
        ret
    }
}