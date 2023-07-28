impl Solution {
    pub fn escape_ghosts(ghosts: Vec<Vec<i32>>, target: Vec<i32>) -> bool {
        
        let (x, y) = (target[0], target[1]);
        let mut manhattan = |a: &Vec<i32>| (a[0] - x).abs() + (a[1] - y).abs();
        manhattan(&vec![0, 0]) < ghosts.iter().map(manhattan).min().unwrap()
    }
}