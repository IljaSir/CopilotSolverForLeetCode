impl Solution {
    pub fn max_area(h: i32, w: i32, horizontal_cuts: Vec<i32>, vertical_cuts: Vec<i32>) -> i32 {
        
        let mut horizontal_cuts = horizontal_cuts;
        let mut vertical_cuts = vertical_cuts;
        horizontal_cuts.push(0);
        horizontal_cuts.push(h);
        vertical_cuts.push(0);
        vertical_cuts.push(w);
        horizontal_cuts.sort();
        vertical_cuts.sort();
        let mut max_h = 0;
        let mut max_v = 0;
        for i in 1..horizontal_cuts.len() {
            max_h = std::cmp::max(max_h, horizontal_cuts[i] - horizontal_cuts[i - 1]);
        }
        for i in 1..vertical_cuts.len() {
            max_v = std::cmp::max(max_v, vertical_cuts[i] - vertical_cuts[i - 1]);
        }
        (max_h * max_v) as i32 % 1000000007
    }
}