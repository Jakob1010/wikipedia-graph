DATE="20220320"
COUNTRY="de"
DOWNLOAD_URL="https://dumps.wikimedia.your.org/${COUNTRY}wiki/$DATE"

FILE_PREFIX="${COUNTRY}wiki-${DATE}-"
FILE_FORMAT=".sql.gz"
PAGE_URL="${DOWNLOAD_URL}/${FILE_PREFIX}page$FILE_FORMAT"
PAGELINKS_URL="${DOWNLOAD_URL}/${FILE_PREFIX}pagelinks$FILE_FORMAT"
REDIRECT_URL="${DOWNLOAD_URL}/${FILE_PREFIX}redirect$FILE_FORMAT"


OUT_DIR="resources"
mkdir -p $OUT_DIR

echo "[INFO] begin download of redirect dump"
echo "[INFO] url: $REDIRECT_URL"
echo
wget -P $OUT_DIR $REDIRECT_URL

echo "[INFO] begin download of page dump"
echo "[INFO] url: $PAGE_URL"
echo
wget -P $OUT_DIR $PAGE_URL


echo "[INFO] begin download of pagelinks"
echo "[INFO] url: $PAGELINKS_URL"
echo
wget -P $OUT_DIR $PAGELINKS_URL


echo "[INFO] finished download"
