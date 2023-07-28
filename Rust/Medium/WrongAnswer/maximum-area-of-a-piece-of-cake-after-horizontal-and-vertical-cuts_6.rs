impl Solution {
    pub fn max_area(h: i32, w: i32, horizontal_cuts: Vec<i32>, vertical_cuts: Vec<i32>) -> i32 {
        
        let mut hcuts = horizontal_cuts.clone();
        hcuts.push(0);
        hcuts.push(h);
        hcuts.sort();
        let mut vcuts = vertical_cuts.clone();
        vcuts.push(0);
        vcuts.push(w);
        vcuts.sort();
        let mut hmax = 0;
        for i in 1..hcuts.len() {
            hmax = hmax.max(hcuts[i] - hcuts[i - 1]);
        }
        let mut vmax = 0;
        for i in 1..vcuts.len() {
            vmax = vmax.max(vcuts[i] - vcuts[i - 1]);
        }
        (hmax * vmax % 1000000007) as i32
    }
}