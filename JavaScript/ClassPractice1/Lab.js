process.stdin.resume();
process.stdin.setEncoding("utf8");

let arr = [];
process.stdin.on("data", function(chunk) {
    arr.push(chunk);
});

process.stdin.on("end", function() {
    main(arr);
});

setTimeout(() => {
    process.stdin.emit('end');
}, 10000);

async function main(arr) {
    await EIMIN(arr);
    process.exit();
}

async function EIMIN(arr) {
    let idx = 0;
    var n = parseInt(arr[idx++]);
    var k = parseInt(arr[idx++]);
    var strArray = [];
    var set = new Set();
    var nums = [];

    for (let i = 0; i < n; i++) {
        set.add(parseInt(arr[idx++]));
    }

    nums = [...set];
    nums.sort((a, b) => a - b);

    for (let i = 0; i < k; i++) {
        let first = nums.shift();
        strArray.push(first);
        nums.forEach((value, index, array) => {
            array[index] = value - first;
        });
        if (nums.length === 0) {
            nums.push(0);
        }
    }
    console.log(strArray.join("\n"));
}

async function EIPAGES() {
    var n = parseInt(await readInput());
    var listPages = [];
    var strArray = [];

    for (let i = 0; i < n; i++) {
        listPages.push(parseInt(await readInput()));
    }

    listPages.sort((a, b) => a - b);

    for (let i = 0; i < listPages.length; ) {
        let start = listPages[i];
        let end = start;

        while (i + 1 < n && listPages[i + 1] === listPages[i] + 1) {
            end = listPages[++i];
        }

        if (end - start >= 2) {
            strArray.push(start + "-" + end + " ");
        } else if (end - start === 1) {
            strArray.push(start + " " + end + " ");
        } else {
            strArray.push(start + " ");
        }

        i++;
    }

    console.log(strArray.join(""));
}
