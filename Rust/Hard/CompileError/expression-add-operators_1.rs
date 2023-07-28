impl Solution {
    pub fn add_operators(num: String, target: i32) -> Vec<String> {
        
        let mut res = vec![];
        let mut path = vec![];
        let mut num = num.as_bytes().to_vec();
        let mut target = target;
        let mut path = vec![];
        dfs(&mut res, &mut path, &mut num, target);
        res
    }
}