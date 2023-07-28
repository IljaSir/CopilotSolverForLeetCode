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
        let mut max_w = 0;
        for i in 0..horizontal_cuts.len() - 1 {
            max_h = max_h.max(horizontal_cuts[i + 1] - horizontal_cuts[i]);
        }
        for i in 0..vertical_cuts.len() - 1 {
            max_w = max_w.max(vertical_cuts[i + 1] - vertical_cuts[i]);
        }
        (max_h * max_w % 1_000_000_007) as i32
    }
}